package net.xiaosaguo.myblog.pojo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * description: 用户 Entity
 *
 * @author xiaosaguo
 * @date 2020/04/24
 */
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Length(max = 20, message = "用户名不能超过20个字符")
    @NotBlank(message = "用户名不能为空")
    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    @Column(unique = true, nullable = false)
    private String email;

    @Length(max = 30, message = "昵称不能超过30个字符")
    @NotBlank(message = "昵称不能为空")
    @Column(unique = true, nullable = false)
    private String nickname;

    private String avatar;

    private Integer type;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createTime;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateTime;

    @OneToMany(mappedBy = "user")
    transient private List<Blog> blogs = new ArrayList<>();

}
