package pt.pa.patterns.memento.model;

import java.util.Collection;
import java.util.Date;

public class ShoppingCartController {
    private ShoppingCart cart;
    private Caretaker caretaker;

    public ShoppingCartController() {
        cart = new ShoppingCart();

    }

    public void addProduct(String name, double cost) {
        caretaker.saveState();

        Product p = new Product(name, cost);
        cart.addProduct(p);
    }

    public void reset() {
        caretaker.saveState();
        cart.reset();
    }

    public void removeProduct(String name) {
        caretaker.saveState();
        for (Product p : cart.getProducts())
            if (p.getName().equals(name)) {
                cart.removeProduct(p);
                return;
            }
        return;
    }


    public void undo() throws NoMementoException {
        caretaker.restoreState();
        System.out.println("Undo feito com sucesso!");
    }

    public Collection<Product> getProducts() {
        return cart.getProducts();
    }

    public String showAll() {
        String str = cart.toString() + "\nTotal price:" + cart.getTotal();
        return str;
    }
}
