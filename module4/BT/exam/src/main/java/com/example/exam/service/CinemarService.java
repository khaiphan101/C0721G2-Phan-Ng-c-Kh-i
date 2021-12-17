//package com.example.exam.service;
//
//import com.example.exam.model.ShowCinema;
//import com.example.exam.repository.CinemarRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//@Service
//public class CinemarService implements ICinemaService{
//    @Autowired
//    CinemarRepository cinemarRepository;
//
//
//    @Override
//    public Page<ShowCinema> findAllCinemaById(int id, Pageable pageable) {
//        return cinemarRepository.findAllCinemaById(id,pageable);
//    }
//
//    @Override
//    public Page<ShowCinema> findAllCinema(Pageable pageable) {
//        return cinemarRepository.findAll(pageable);
//    }
//
//    @Override
//    public List<ShowCinema> findAll() {
//        return cinemarRepository.findAll();
//    }
//
//    @Override
//    public Object findAllCinemaByMovie(String name, Pageable pageable) {
//        return cinemarRepository.findAllCinemaByMovie(name, pageable);
//    }
//
//    @Override
//    public Optional<ShowCinema> findById(String id) {
//        return cinemarRepository.findById(id);
//    }
//
//    @Override
//    public void deleteById(String id) {
//        cinemarRepository.deleteById(id);
//    }
//
//    @Override
//    public void save(ShowCinema showCinema) {
//        cinemarRepository.save(showCinema);
//    }
//}
