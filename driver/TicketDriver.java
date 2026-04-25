package driver;

import model.Ticket;
import java.util.Scanner;

public class TicketDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== Selamat Datang di EventSwift Booking ===");
        System.out.println("Pilih Kategori: 1. Reguler (100rb) | 2. VIP (300rb) | 3. Premium (500rb)");
        System.out.print("Pilihan: ");
        int choice = input.nextInt();

        String category = (choice == 1) ? "Reguler" : (choice == 2) ? "VIP" : "Premium";
        double basePrice = (choice == 1) ? 100000 : (choice == 2) ? 300000 : 500000;

        Ticket myTicket = new Ticket("Java Conference 2026", category, basePrice);
        
        System.out.println("\nPilih Metode Pembayaran: 1. QRIS | 2. Cash");
        System.out.print("Pilihan: ");
        int payChoice = input.nextInt();
        String paymentMethod = (payChoice == 1) ? "QRIS" : "Cash";

        processBooking(myTicket, paymentMethod);
        
        input.close();
    }

    public static void processBooking(Ticket ticket, String method) {
        // --- LOCAL CLASS ---
        class PriceCalculator {
            double calculate() {
                double discount = switch (ticket.category()) {
                    case "Premium" -> 0.15;
                    case "VIP" -> 0.10;
                    default -> 0.0;
                };
                return ticket.basePrice() - (ticket.basePrice() * discount);
            }
        }

        double finalPrice = new PriceCalculator().calculate();

        // --- ANONYMOUS CLASS ---
        // Kita mendefinisikan perilaku pembayaran berdasarkan metode yang dipilih
        interface PaymentGateway {
            void pay(double amount);
        }

        PaymentGateway paymentProcessor = new PaymentGateway() {
            @Override
            public void pay(double amount) {
                if (method.equals("QRIS")) {
                    System.out.println(">> Menggenerate kode QR unik...");
                    System.out.println(">> Pembayaran QRIS sebesar Rp" + amount + " terverifikasi.");
                } else {
                    System.out.println(">> Menyiapkan formulir kasir...");
                    System.out.println(">> Pembayaran Cash sebesar Rp" + amount + " diterima.");
                }
            }
        };

        System.out.println("\n--- Ringkasan Pemesanan ---");
        System.out.println("Event: " + ticket.eventName() + " | Kategori: " + ticket.category());
        paymentProcessor.pay(finalPrice);
    }
}