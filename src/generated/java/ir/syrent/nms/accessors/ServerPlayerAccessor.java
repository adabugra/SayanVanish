package ir.syrent.nms.accessors;

import java.lang.Class;
import java.lang.reflect.Field;

/**
 * Class generated by NMS Mapper.
 * <p>
 * This class is a reflection accessor for net.minecraft.server.level.ServerPlayer
 *
 * @since 2023-10-01 13:06:03
 */
public class ServerPlayerAccessor {
  /**
   * This method returns the {@link Class} object of the requested NMS class.
   * <p>
   * This method is safe to call: exception is handled and null is returned in case of failure.
   *
   * @return the resolved class object or null if the class does not exist
   */
  public static Class<?> getType() {
    return AccessorUtils.getType(ServerPlayerAccessor.class, mapper -> {

          /* SEARGE */
          mapper.map("SEARGE", "1.8.8", "net.minecraft.entity.player.EntityPlayerMP"); // 1.8.8 - 1.13.2
          mapper.map("SEARGE", "1.14", "net.minecraft.entity.player.ServerPlayerEntity"); // 1.14 - 1.16.5
          mapper.map("SEARGE", "1.17", "net.minecraft.src.C_13_"); // 1.17 - 1.20.2

          /* SPIGOT */
          mapper.map("SPIGOT", "1.8.8", "net.minecraft.server.${V}.EntityPlayer"); // 1.8.8 - 1.16.5
          mapper.map("SPIGOT", "1.17", "net.minecraft.server.level.EntityPlayer"); // 1.17 - 1.20.2

        });
  }

  /**
   * This method returns the {@link Field} object of the requested NMS field.
   * <p>
   * Requested field: connection, mapping: mojang
   * <p>
   * This method is safe to call: exception is handled and null is returned in case of failure.
   *
   * @return the resolved field object or null if either class does not exist or it does not have this field in the specific environment
   */
  public static Field getFieldConnection() {
    return AccessorUtils.getField(ServerPlayerAccessor.class, "connection1", mapper -> {

          /* SEARGE */
          mapper.map("SEARGE", "1.8.8", "field_71135_a"); // 1.8.8 - 1.16.5
          mapper.map("SEARGE", "1.17", "f_8906_"); // 1.17 - 1.20.2

          /* SPIGOT */
          mapper.map("SPIGOT", "1.8.8", "playerConnection"); // 1.8.8 - 1.16.5
          mapper.map("SPIGOT", "1.17", "b"); // 1.17 - 1.19.4
          mapper.map("SPIGOT", "1.20", "c"); // 1.20 - 1.20.2

        });
  }
}
