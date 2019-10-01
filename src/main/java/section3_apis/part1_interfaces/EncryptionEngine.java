package section3_apis.part1_interfaces;

public interface EncryptionEngine {
    String encrypt(String message);
    String decrypt(String encryptedMessage);
}
