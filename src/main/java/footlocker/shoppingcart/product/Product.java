package footlocker.shoppingcart.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@TypeAlias("product")
public class Product {

//    @Id @GeneratedValue( delimiter = "::", strategy = GenerationStrategy.UNIQUE)
    @Id
    public String sku;
    public String name;
    public String size;
    public String color;
    public String brand;
    public boolean backorderFlag;
    public boolean launchSkuFlag;
    public boolean presell;
    public String taxCode;
    public String productDesignator;
    public String productNumber;
    public String productType;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double price;

    public Product() {

    }

    public Product(String sku, String name, String size, String color, String brand, boolean backorderFlag, boolean launchSkuFlag, boolean presell, String taxCode, String productDesignator, String productNumber, String productType, String sizeDisplayed, Double price) {
        this.sku = sku;
        this.name = name;
        this.size = size;
        this.color = color;
        this.brand = brand;
        this.backorderFlag = backorderFlag;
        this.launchSkuFlag = launchSkuFlag;
        this.presell = presell;
        this.taxCode = taxCode;
        this.productDesignator = productDesignator;
        this.productNumber = productNumber;
        this.productType = productType;
        this.sizeDisplayed = sizeDisplayed;
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isBackorderFlag() {
        return backorderFlag;
    }

    public void setBackorderFlag(boolean backorderFlag) {
        this.backorderFlag = backorderFlag;
    }

    public boolean isLaunchSkuFlag() {
        return launchSkuFlag;
    }

    public void setLaunchSkuFlag(boolean launchSkuFlag) {
        this.launchSkuFlag = launchSkuFlag;
    }

    public boolean isPresell() {
        return presell;
    }

    public void setPresell(boolean presell) {
        this.presell = presell;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getProductDesignator() {
        return productDesignator;
    }

    public void setProductDesignator(String productDesignator) {
        this.productDesignator = productDesignator;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getSizeDisplayed() {
        return sizeDisplayed;
    }

    public void setSizeDisplayed(String sizeDisplayed) {
        this.sizeDisplayed = sizeDisplayed;
    }

    public String sizeDisplayed;
}
