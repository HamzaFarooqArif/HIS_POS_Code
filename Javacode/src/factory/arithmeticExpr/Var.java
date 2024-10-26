package factory.arithmeticExpr;

public class Var implements ArithmeticExpr{
    /* fields */
    String name;
    /* constructor */
    Var(String n) {
        name = n; }
    /* toString */
    public String toString() {
        return name;
    }

    @Override
    public Const eval() {
        return Environment.env.get(name);
    }

    @Override
    public void setLeft(ArithmeticExpr left) {
        throw new UnsupportedOperationException("Const does not support this");
    }

    @Override
    public void setRight(ArithmeticExpr right) {
        throw new UnsupportedOperationException("Const does not support this");
    }

    @Override
    public int precedenceLevel() {
        return 0;
    }
}
