# Beer
Tp cerveceria David Navarro

//-Se necesita solo 1 consumidor para que el stock llegue a 0, mientras se implemente adecuadamente, tabien se puede tener
cinsumidores en el mismo consumidor.

-Los bloques deben ser synchronized para que se ejecuten sinconicamente y no accedean a diferentes metods en cualquier momento
lo hace sincronisado uno a la vez.

-El recurso compartido es aquel al que tienen acceso distintos procesos y pueden realizar cambios en el mismo. 
Si no se encuentra gestionado el acceso se pueden perder datos durante la sobreescritura esto seria critico ya que no sabria en que estado esta. 
Estados recién creada, "corrible", bloqueada, o muerta.

-Se puede instanciar un Thread de las siguientes formas:

  *Mediante la imprementación de la Interfaz Runneable.

  *Extendiendo de la clase Thread.

  *Creando un objeto Thread.
