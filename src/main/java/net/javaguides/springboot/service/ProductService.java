package net.javaguides.springboot.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.javaguides.springboot.chatgptintegeration.ChatGPT;
import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class ProductService {

    public void loadDataFromJson() throws IOException {
        ChatGPT chatGPT=new ChatGPT();
        String chatGPTResponse=chatGPT.generateChatGPTResponse("What is dog?");
        System.out.println(chatGPTResponse);

    }
    public ArrayList<String> getDataJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(new File("./src/payload/payload.json"));
       ArrayList<String> productName = new ArrayList<>();
       for(int i=0;i< jsonNode.size();i++)
           productName.add(jsonNode.get(i).get("lastName").asText());
        System.out.println("Name:  " + productName);
        return productName;
    }
    public boolean checkExistingEmailId(String emailId,ProductRepository productRepository)
    {
        ArrayList<Product> productArrayList;
        productArrayList= (ArrayList<Product>) productRepository.findAll();
        for(Product product:productArrayList)
        {
            if(product.getEmailId().equals(emailId))
                return true;
        }
        return false;
    }
    public Product saveFromAnotherObject(Product productDetails)
    {
       Product product=new Product();
        product.setProductName(productDetails.getProductName());
        product.setType(productDetails.getType());
        product.setEmailId(productDetails.getEmailId());
        return product;
    }
}
