package com.acceptingOrders.Ozon.service;

import com.acceptingOrders.Ozon.model.Order;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;


    @Override
    public void sendOrderEmail(@NotNull Order order, String recipientEmail) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
            try {
                LocalDate deadlineDate = order.getDate();
                deadlineDate = deadlineDate.plusDays(7);
                helper.setTo(recipientEmail);
                helper.setSubject("Информация о заказе");
                helper.setText("Номер заказа: " + order.getOrderNumber() + "\n" +
                        "ФИО получателя: " + order.getFullName() + "\n" +
                        "Дата приезда заказа: " + order.getDate() + "\n" +
                        "Дата дедлайна хранения: " + deadlineDate);
                javaMailSender.send(message);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
    }
}
