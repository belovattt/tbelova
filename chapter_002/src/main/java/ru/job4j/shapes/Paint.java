package ru.job4j.shapes;

import ru.job4j.module2.Output;

public class Paint {
    private Output output;
    private Shape shape;
    Paint(Shape shape, Output output) {
        this.shape = shape;
        this.output = output;
    }
    public void setOutput(Output output) {
        this.output = output;
    }
    public void draw() {
        this.output.write(this.shape.pic());
    }
}
