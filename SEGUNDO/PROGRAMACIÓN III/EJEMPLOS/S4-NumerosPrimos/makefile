#
# NumerosPrimos - hace uso de DiaUtil en com/coti/tools
#
# Usar make whole para crear el jar completo
#
program.jar: Main.class primecalculators/Good.class  primecalculators/Better.class  primecalculators/Optimized.class 
	jar cmfv manifest program.jar *.class primecalculators/*.class

Main.class : Main.java
	javac Main.java

primecalculators/Good.class:  primecalculators/Good.java
	javac  primecalculators/Good.java

primecalculators/Better.class:  primecalculators/Better.java
	javac  primecalculators/Better.java

primecalculators/Optimized.class:  primecalculators/Optimized.java
	javac  primecalculators/Optimized.java


whole:
	make
	jar uf program.jar -C /Users/$(USER)/Documents/lib/java com/coti/tools/DiaUtil.class
lean:
	rm -rf *.class
	rm -rf primecalculators/*.class
clean:
	rm -rf *.class
	rm -rf primecalculators/*.class
	rm -rf program.jar
