# Importar librerías y cargar datos
from keras.models import Sequential
from keras.layers import Dense , Activation
from sklearn.datasets import load_digits
from sklearn.model_selection import train_test_split
import numpy as np

data = load_digits()
X = data["data"]
Y = data["target"]

# Dividir datos y crear matrices con formato One-Hot
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.3)
Y_train_ohe = np.zeros((Y_train.shape[0], 10))
Y_test_ohe = np.zeros((Y_test.shape[0], 10))
for i in range(Y_train.shape[0]):
    Y_train_ohe[i, Y_train[i]] = 1
for i in range(Y_test.shape[0]):
    Y_test_ohe[i , Y_test[i]] = 1

# Definir red neuronal
model = Sequential()
model.add(Dense(80, activation = "relu"))
model.add(Dense(35, activation = "sigmoid"))
model.add(Dense(10, activation = "softmax"))

# Asignar función de error
model.compile(loss = 'mse', optimizer = 'sgd', metrics = ['accuracy'])

# Entrenar modelo
model.fit(X_train, Y_train_ohe, nb_epoch = 4100, batch_size = 40)

# Generar resumen
print(model.summary())

# Evaluar red entrenada
print(model.evaluate(X_test, Y_test_ohe, batch_size = 40)) # Imprime:  Valor función de error = 0.006929711346101321
                                                           #           Porcentaje de acierto = 0.9652294929402262