CLASS = GraphicsSample

run: $(CLASS).class
	java $(CLASS)

%.class: %.java
	javac $<
