program.jar: Principal.class Alumno.class
	jar cmfv manifest $@ $^

Principal.class: Principal.java
	javac $^

Alumno.class: Alumno.java
	javac $^

clean:
	rm *.class
	rm program.jar

lean:
	rm *.class


