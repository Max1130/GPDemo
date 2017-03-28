package util;

import java.util.UUID;

public class UuidUtil {
	public static String generateUUID() {
		String uuid = UUID.randomUUID().toString();
		uuid = uuid.replace("-", "");
		return uuid;
	}
}
