//package com.codeup.codeupspringblog.models;
//import lombok.*;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
//public class Post {
//    private long id;
//    private String title;
//    private String body;
//
//    public Post(String title, String body) {
//        this.title = title;
//        this.body = body;
//    }
//}

package com.codeup.codeupspringblog.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    private long id;
    private String title;
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
}