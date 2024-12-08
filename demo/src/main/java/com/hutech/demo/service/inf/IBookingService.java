package com.hutech.demo.service.inf;

import com.hutech.demo.createrequest.CreateBookingRequest;
import com.hutech.demo.filter.BookingFilter;
import com.hutech.demo.model.Booking;
import com.hutech.demo.response.BookingResponse;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    BookingResponse createBooking(CreateBookingRequest request);
    BookingResponse updateBookingStatus(Long id, String status);
    void deleteBooking(Long id);
    BookingResponse getBookingById(Long id);
    List<BookingResponse> getAllBookings(BookingFilter filter);
}
