program.jar: BusquedaBinFrente.class
	jar cmfv manifest $@ $^
	jar uf program.jar -C /Users/$(USER)/Documents/lib/java/ com/coti/tools/DiaUtil.class

%.class: %.java
	javac $^

clean:
	rm -rf *.class

lean:
	rm -rf program.jar
