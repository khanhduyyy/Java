package Springweb;


import Springweb.controller.ShoppingCartController;
import Springweb.entity.Customers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class SpringwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringwebApplication.class, args);
                
              //  VegetableModel m = new VegetableModel();
                //List<Vegetable> list = m.getAll();
                //list.forEach(System.out::println);
                
	}
        @Bean(name="CUSTOMER_BEAN")
        public Customers setCustomers()
        {
            Customers c=new Customers();
            c.setUsername("admin");
            c.setPassword("123");
            return c;
        }

}
