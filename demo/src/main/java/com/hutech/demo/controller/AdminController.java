//package com.hutech.demo.controller;
//
//import com.hutech.demo.model.*;
//import com.hutech.demo.repository.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/admin")
//public class AdminController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private BookingRepository bookingRepository;
//
//    @Autowired
//    private ServiceRepository serviceRepository;
//
//    @Autowired
//    private PaymentRepository paymentRepository;
//
//    @Autowired
//    private ReviewRepository reviewRepository;
//
//    // 1. Quản lý tài khoản (Thêm, sửa, xóa)
//    @PostMapping("/addUser")
//    public ResponseEntity<String> addUser(@RequestBody User user) {
//        if (userRepository.existsByUsername(user.getUsername())) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
//        }
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));  // Mã hóa mật khẩu
//        userRepository.save(user);
//        return ResponseEntity.ok("User added successfully");
//    }
//
//    @PutMapping("/updateUser/{id}")
//    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody User user) {
//        Optional<User> existingUser = userRepository.findById(id);
//        if (!existingUser.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//        }
//        User u = existingUser.get();
//        u.setUsername(user.getUsername());
//        u.setEmail(user.getEmail());
//        u.setRoles(user.getRoles());
//        userRepository.save(u);
//        return ResponseEntity.ok("User updated successfully");
//    }
//
//    @DeleteMapping("/deleteUser/{id}")
//    public ResponseEntity<String> deleteUser(@PathVariable int id) {
//        Optional<User> existingUser = userRepository.findById(id);
//        if (!existingUser.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
//        }
//        userRepository.deleteById(id);
//        return ResponseEntity.ok("User deleted successfully");
//    }
//
//    // 2. Quản lý lịch đặt
//    @GetMapping("/getBookings")
//    public ResponseEntity<List<Booking>> getBookings() {
//        List<Booking> bookings = bookingRepository.findAll();
//        return ResponseEntity.ok(bookings);
//    }
//
//    @PutMapping("/updateBookingStatus/{id}")
//    public ResponseEntity<String> updateBookingStatus(@PathVariable int id, @RequestBody String status) {
//        Optional<Booking> booking = bookingRepository.findById(id);
//        if (!booking.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not found");
//        }
//        Booking b = booking.get();
//        b.setStatus(status);
//        bookingRepository.save(b);
//        return ResponseEntity.ok("Booking status updated");
//    }
//
//    // 3. Quản lý dịch vụ (Thêm, sửa, xóa)
//    @PostMapping("/addService")
//    public ResponseEntity<String> addService(@RequestBody Service service) {
//        serviceRepository.save(service);
//        return ResponseEntity.ok("Service added successfully");
//    }
//
//    @PutMapping("/updateService/{id}")
//    public ResponseEntity<String> updateService(@PathVariable int id, @RequestBody Service service) {
//        Optional<Service> existingService = serviceRepository.findById(id);
//        if (!existingService.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
//        }
//        Service s = existingService.get();
//        s.setName(service.getName());
//        s.setDescription(service.getDescription());
//        s.setPrice(service.getPrice());
//        serviceRepository.save(s);
//        return ResponseEntity.ok("Service updated successfully");
//    }
//
//    @DeleteMapping("/deleteService/{id}")
//    public ResponseEntity<String> deleteService(@PathVariable int id) {
//        Optional<Service> existingService = serviceRepository.findById(id);
//        if (!existingService.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Service not found");
//        }
//        serviceRepository.deleteById(id);
//        return ResponseEntity.ok("Service deleted successfully");
//    }
//
//    // 4. Quản lý thanh toán
//    @GetMapping("/getPayments")
//    public ResponseEntity<List<Payment>> getPayments() {
//        List<Payment> payments = paymentRepository.findAll();
//        return ResponseEntity.ok(payments);
//    }
//
//    @PutMapping("/updatePaymentStatus/{id}")
//    public ResponseEntity<String> updatePaymentStatus(@PathVariable int id, @RequestBody String paymentStatus) {
//        Optional<Payment> payment = paymentRepository.findById(id);
//        if (!payment.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Payment not found");
//        }
//        Payment p = payment.get();
//        p.setPaymentStatus(paymentStatus);
//        paymentRepository.save(p);
//        return ResponseEntity.ok("Payment status updated");
//    }
//
//    // 5. Quản lý phản hồi và đánh giá
//    @GetMapping("/getReviews")
//    public ResponseEntity<List<Review>> getReviews() {
//        List<Review> reviews = reviewRepository.findAll();
//        return ResponseEntity.ok(reviews);
//    }
//
//    @DeleteMapping("/deleteReview/{id}")
//    public ResponseEntity<String> deleteReview(@PathVariable int id) {
//        Optional<Review> review = reviewRepository.findById(id);
//        if (!review.isPresent()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
//        }
//        reviewRepository.deleteById(id);
//        return ResponseEntity.ok("Review deleted successfully");
//    }
//}
//
