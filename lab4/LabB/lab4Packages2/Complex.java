package lab4Packages2;

public class Complex<T extends Number> {
    private T real;
    private T img;

    public Complex(T real, T img) {
        this.real = real;
        this.img = img;
    }
    
    public void setImg(T img) {
        this.img = img;
    }

    public T getImg() {
        return img;
    }

    public void setReal(T real) {
        this.real = real;
    }

    public T getReal() {
        return real;
    }

    public void display() {
        if (this.real.doubleValue() == 0 && this.img.doubleValue() == 0) {
            System.out.println("0");
            return;
        }

        if (this.real.doubleValue() != 0)
            System.out.print(this.real);
        if (this.img.doubleValue() > 0)
            System.out.println("+" + this.img + "j");
        else if (this.img.doubleValue() < 0)
            System.out.println(this.img + "j");
    }

    public Complex<?> addition(Complex<?> other) {
        double newReal = this.real.doubleValue() + other.real.doubleValue();
        double newImg = this.img.doubleValue() + other.img.doubleValue();
        return new Complex<Double>(newReal, newImg);
    }

    public Complex<?> subtract(Complex<?> other) {
        double newReal = this.real.doubleValue() - other.real.doubleValue();
        double newImg = this.img.doubleValue() - other.img.doubleValue();
        return new Complex<Double>(newReal, newImg);
    }
}