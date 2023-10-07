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
    Long theatreId;
    @Column(name = "theatre_name")
    String theatreName;
    @Column(name = "address_id")
    int addressId;
    @OneToMany(mappedBy = "theatre", fetch = FetchType.LAZY, orphanRemoval = false)
    private List<Show> listOfShow = new ArrayList<>();

}
