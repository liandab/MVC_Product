package model;

import java.util.List;

import jakarta.servlet.ServletContext;
import operations.OperatorImplementor;

public class Product_pojo {
    private int pid;
    private String pname;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    // Pass ServletContext when calling OperatorImplementor
    public void saveProduct(Product_pojo pojo, ServletContext context) {
        new OperatorImplementor(context).save(pojo);
    }

    public void updateProduct(Product_pojo pojo, ServletContext context) {
        new OperatorImplementor(context).update(pojo);
    }

    public void deleteProduct(Product_pojo pojo, ServletContext context) {
        new OperatorImplementor(context).delete(pojo);
    }

    public List<Product_pojo> show(ServletContext context) {
        return new OperatorImplementor(context).show();
    }
}
