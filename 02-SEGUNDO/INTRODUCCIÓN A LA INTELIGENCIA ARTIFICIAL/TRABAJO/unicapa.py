# Importar librerías y cargar datos
from sklearn.datasets import load_digits
from sklearn.metrics import accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.metrics import accuracy_score
import numpy as np

digits = load_digits()
X, Y = digits.data, digits.target

# Dividir datos y añadir característica auxiliar
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.3)

X_train = np.concatenate([np.ones((X_train.shape[0], 1)), X_train], axis = 1)
X_test = np.concatenate([np.ones((X_test.shape[0], 1)), X_test], axis = 1)

# Generar las matrices con las salidas ideales (codificación One-Hot)
Y_train_ohe = -np.ones((Y_train.shape[0], 10))
Y_test_ohe = -np.ones((Y_test.shape[0], 10))

for i in range(Y_train.shape[0]):
    Y_train_ohe [i, Y_train[i]] = 1

for i in range(Y_test.shape[0]):
    Y_test_ohe [i , Y_test [i]] = 1

# Creación de hiperparámetros y matriz de pesos
N_ITER = 65000
lr = 0.000015
n_neurons = 10
n = float(X_train.shape[0])
W = np.random.randn(65, n_neurons) / 100

# Ejecutar descenso de gradiente para entrenar
for i in range (N_ITER):
    z = np.dot(X_train, W)
    gradient = -np.dot(X_train.T, (Y_train_ohe - z)) / n
    dw = -lr * gradient
    W = W + dw

# Calcular las predicciones de la red para las muestras de test
y = np.dot(X_test, W)

# Transformar las salidas de la red en etiquetas de clase
y = np.argmax(y, axis = 1)

# Evaluar tasa de acierto
print(accuracy_score(y, Y_test))    # Imprime 0.9314814814814815