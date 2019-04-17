# Importar clases
from keras.models import Sequential
from keras.layers import Dense, Conv2D, MaxPooling2D, Flatten, Dropout
from keras.datasets import mnist
from keras.utils import to_categorical
import keras.backend as K
import numpy as np
import matplotlib.pyplot as plt

# Comprobar formato
print(K.image_data_format())    # Imprime: Using TensorFlow backend. channels_last

# Cargar datos en memoria
(X_train, Y_train ), (X_test, Y_test) = mnist.load_data()
print(X_train.shape)    # Imprime: (60000, 28, 28)

# Visualizar algunas muestras aleatorias del dataset
f, axes = plt.subplots(1, 10)

for ax in axes.ravel():
    ax.imshow(X_train[np.random.randint(60000)], cmap = "gray")
    ax.get_xaxis().set_visible(False)
    ax.get_yaxis().set_visible(False)
plt.show()

# Preparar muestras para su procesamiento y crear los vectores de entrenamiento y test formato One-Hot
X_train = X_train.reshape(X_train.shape[0], 28, 28, 1) / 255
X_test = X_test.reshape(X_test.shape[0], 28, 28, 1) / 255

Y_train_ohe = to_categorical(Y_train, num_classes = 10)
Y_test_ohe = to_categorical(Y_test, num_classes = 10)

# Definir modelo
model = Sequential ()
model.add(Conv2D(25, kernel_size = (5, 5), padding = "same", activation = "relu", input_shape = (28, 28, 1)))
model.add(MaxPooling2D(pool_size = (2, 2)))
model.add(Conv2D(25, kernel_size = (3, 3), padding = "same", activation = "relu", input_shape = (28, 28, 1)))
model.add(Dropout(0.20))
model.add(MaxPooling2D(padding = "same"))
model.add(Flatten())
model.add(Dense(350, activation = "relu"))
model.add(Dense(10, activation = "softmax"))

# Asignar funci?n de error y algoritmo de optimizaci?n
model.compile(loss = 'categorical_crossentropy', optimizer = 'sgd', metrics = ['accuracy'])

# Entrenar modelo
model.fit(X_train, Y_train_ohe, epochs = 15, batch_size = 120)

# Evaluar tasa de acierto
print(model.evaluate(X_test, Y_test_ohe))   # Imprime:  Valor funci?n de error = 0.054705479830503
                                            #           Porcentaje de acierto = 0.985