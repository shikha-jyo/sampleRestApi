package com.example.MovieApp;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "theatre")
public class Theatre {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "theatre_id")
    private Long theatreId;
    @Column(name = "theatre_name")
    private String theatreName;
    @Column(name = "address_id")
    private int addressId;
    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Show> listOfShow = new ArrayList<>();

}
