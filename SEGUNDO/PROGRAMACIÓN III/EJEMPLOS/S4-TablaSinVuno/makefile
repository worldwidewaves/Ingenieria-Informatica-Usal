#
# TablaCon - hace uso de DiaUtil en com/coti/tools
#
# Usar make whole para crear el jar completo
#
program.jar: Main.class 
	jar cmfv manifest program.jar *.class 

Main.class : Main.java
	javac Main.java
	
whole:
	make
	jar uf program.jar -C /Users/coti/Documents/lib/java com/coti/tools/DiaUtil.class
lean:
	rm -rf *.class
clean:
	rm -rf *.class
	rm -rf program.jar
