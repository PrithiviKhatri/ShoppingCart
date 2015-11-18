package mum.edu.shoppingcart.schedular;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mum.edu.shoppingcart.domain.Product;
import mum.edu.shoppingcart.service.ProductService;


@SessionAttributes("productObj")
public class SchedularServiceImpl implements SchedularService {
@Autowired
ProductService productService;

    //@Scheduled(cron="0/7 * * * * *")
    public void getStocks() {
        Date date = Calendar.getInstance().getTime();
        DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.DEFAULT);
        String currenttime = timeFormatter.format(date);

        ModelAndView modelAndView = new ModelAndView();
         
        List<Product> productlist = new ArrayList<Product>();
        
        System.out.println(currenttime + "    Generating Lower Inventory");
        List<Product> product=productService.getAllProducts();
        for(Product singleproduct : product ){
            if(singleproduct.getQuantity()<10){
            	productlist.add(singleproduct);
            	System.out.println("==================================================");	
            	System.out.println("Name:-"+singleproduct.getName()+"\n");	
            	System.out.println("Quantity:-"+singleproduct.getQuantity()+"\n");	
            	System.out.println("Product Code:-"+singleproduct.getProductcode()+"\n");	
            	
            }
         }
       
      //  System.out.println(productlist.size()+"KKKKKKKKKKKKKKKKKKKKKKKKKk"+product.size());
        modelAndView.addObject("productObj", productlist);
    }
    
   

}
