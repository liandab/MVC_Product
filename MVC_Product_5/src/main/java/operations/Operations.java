package operations;
import java.util.List;
import model.Product_pojo;

public interface Operations {
	void save(Product_pojo pojo);
	void update(Product_pojo pojo);
	void delete(Product_pojo pojo);
	List<Product_pojo> show();
}
