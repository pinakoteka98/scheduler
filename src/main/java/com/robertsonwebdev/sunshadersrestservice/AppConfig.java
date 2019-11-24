package com.robertsonwebdev.sunshadersrestservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Configuration
public class AppConfig {

    public AppointmentRepository appointmentRepository(){
        return new AppointmentRepository() {

            @Override
            public List<Appointment> findAllByAppointmentDate(Date date) { return null; }

            @Override
            public <S extends Appointment> S save(S s) {
                return null;
            }

            @Override
            public <S extends Appointment> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Appointment> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Appointment> findAll() {
                return null;
            }

            @Override
            public Iterable<Appointment> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Appointment appointment) {

            }

            @Override
            public void deleteAll(Iterable<? extends Appointment> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

    public UserRepository userRepository(){
        return new UserRepository() {
            @Override
            public User findByEmail(String email) {
                return null;
            }

            @Override
            public <S extends User> S save(S s) {
                return null;
            }

            @Override
            public <S extends User> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<User> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<User> findAll() {
                return null;
            }

            @Override
            public Iterable<User> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(User user) {

            }

            @Override
            public void deleteAll(Iterable<? extends User> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }
}
