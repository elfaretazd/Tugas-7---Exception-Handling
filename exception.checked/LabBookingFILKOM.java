package exception.checked;

import java.util.Scanner;

public class LabBookingFILKOM {

    public static void validateNIM(String nim) throws InvalidNIMException {
        if (nim == null || !nim.matches("\\d{15}")) {
            throw new InvalidNIMException("NIM harus terdiri dari 15 digit angka.");
        }
    }

    public static void validateLab(String lab) throws InvalidLabException {
        if (!lab.equalsIgnoreCase("AI") &&
            !lab.equalsIgnoreCase("CyberSec") &&
            !lab.equalsIgnoreCase("DataSci")) {
            throw new InvalidLabException("Lab tidak tersedia. Pilih: AI, CyberSec, atau DataSci.");
        }
    }

    public static void validateDay(String day) throws InvalidDayException {
        if (day.equalsIgnoreCase("Minggu")) {
            throw new InvalidDayException("Lab tidak dapat dipesan pada hari Minggu.");
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("=== Sistem Pemesanan Lab Riset FILKOM ===");

            System.out.print("Masukkan NIM Anda: ");
            String nim = input.nextLine();

            System.out.print("Pilih lab (AI, CyberSec, DataSci): ");
            String lab = input.nextLine();

            System.out.print("Masukkan hari pemesanan: ");
            String day = input.nextLine();

            // Validasi input
            validateNIM(nim);
            validateLab(lab);
            validateDay(day);

            // Jika semua validasi lolos
            System.out.println("Pemesanan berhasil untuk Lab " + lab + " pada hari " + day + ".");
            System.out.println("Terima kasih, NIM " + nim + ".");

        } catch (InvalidNIMException | InvalidLabException | InvalidDayException e) {
            System.out.println("Gagal memesan: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan input.");
        }
    }
}
