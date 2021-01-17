package com.ymj.mongodb.docment;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author ywx
 * @version V1.0
 * @package com.ymj.mongodb.docment
 * @date 2020/8/14 14:31
 * @description
 */
@Data
@Document(collection = "user_collection")
public class UserDocument {

    @Id
    private String id;

    private String name;

    private int age;

}