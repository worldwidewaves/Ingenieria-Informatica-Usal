#
# SumaNumerosConSin - hace uso de DiaUtil en com/coti/tools
#
# Usar make whole para crear el jar completo
#
program.jar: Main.class calculadoras/SinIndices.class calculadoras/ConIndices.class
	jar cmfv manifest program.jar *.class calculadoras/*.class

Main.class : Main.java
	javac Main.java

calculadoras/SinIndices.class: calculadoras/SinIndices.java
	javac calculadoras/SinIndices.java
	
calculadoras/ConIndices.class: calculadoras/ConIndices.java
	javac calculadoras/ConIndices.java
	
whole:
	make
	jar uf program.jar -C /Users/coti/Documents/lib/java com/coti/tools/DiaUtil.class
lean:
	rm -rf *.class
clean:
	rm -rf *.class
	rm -rf program.jar
