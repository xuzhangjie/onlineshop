package pojo;

/**
 * @author pangjian
 * @ClassName Commodity
 * @Description 商品实体类
 * @date 2021/4/26 13:04
 */

public class Commodity {

    private String code;
    private String name;
    private Integer amt;
    private Double price;
    private Integer num;

    public Commodity(String code, String name, Integer amt, Double price, Integer num) {
        this.code = code;
        this.name = name;
        this.amt = amt;
        this.price = price;
        this.num = num;
    }

    public Commodity() {

    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmt() {
        return amt;
    }

    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
