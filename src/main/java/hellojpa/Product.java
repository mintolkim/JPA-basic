

package hellojpa;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column (name = "PRODUCT_ID")
    private long id;

    private String name;

    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts;


}


