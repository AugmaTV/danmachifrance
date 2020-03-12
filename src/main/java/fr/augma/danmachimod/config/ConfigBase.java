package fr.augma.danmachimod.config;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.SERVER)
public class ConfigBase {
	public static Configuration config;
	private static String filePath;
	
	public ConfigBase(String fileName) {
		filePath = "config/danmachifrance/" + fileName + ".cfg";
		config = new Configuration(new File(filePath));
	}
	
	public Configuration getConfigFile() {
		return config;
	}
	
	public static void removeConfig(String category) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.hasCategory(category))
				config.removeCategory(new ConfigCategory(category));
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}
	
	/*
	 * Removes specific key in specific category from configuration file.
	 */
	public static void removeConfig(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key))
				config.getCategory(category).remove(key);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}
	
	public static int getInt(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, 0).getInt();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return 0;
	}
	
	public static double getDouble(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, 0D).getDouble();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return 0D;
	}
	
	public static float getFloat(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return (float)config.get(category, key, 0D).getDouble();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return 0f;
	}
	
	public static String getString(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, "").getString();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return "";
	}
	
	public static long getLong(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return config.get(category, key, 0L).getLong();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return 0L;
	}
	
	public static short getShort(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return (short)config.get(category, key, (short)0).getInt();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return (short)0;
	}
	
	public static byte getByte(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key)) {
				return (byte)config.get(category, key, (byte)0).getInt();
			}
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return (byte)0;
	}
	
	public static boolean getBoolean(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (config.getCategory(category).containsKey(key))
				return config.get(category, key, false).getBoolean();
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return false;
	}
	
	public static void writeConfig(String category, String key, String value) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			String set = config.get(category, key, value).getString();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}
	
	public static void writeConfig(String category, String key, int value) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			int set = config.get(category, key, value).getInt();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}
	
	public static void writeConfig(String category, String key, boolean value) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			boolean set = config.get(category, key, value).getBoolean();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}
	
	public static void writeConfig(String category, String key, long value) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			long set = config.get(category, key, value).getLong();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}
	
	public static void writeConfig(String category, String key, double value) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			double set = config.get(category, key, value).getDouble();
			config.getCategory(category).get(key).set(value);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}
	
	public static void writeConfig(String category, String key, short value) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			int set = config.get(category, key, value).getInt();
			config.getCategory(category).get(key).set(Integer.valueOf(value));
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, byte value) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			int set = config.get(category, key, value).getInt();
			config.getCategory(category).get(key).set(Integer.valueOf(value));
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}

	public static void writeConfig(String category, String key, float value) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			double set = config.get(category, key, value).getDouble();
			config.getCategory(category).get(key).set(Double.valueOf(value));
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
	}
	
	public static boolean hasCategory(String category) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			return config.hasCategory(category);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return false;
	}
	
	public static boolean hasKey(String category, String key) {
		config = new Configuration(new File(filePath));
		try {
			config.load();
			if (!config.hasCategory(category))
				return false;
			return config.getCategory(category).containsKey(key);
		} catch (Exception e) {
			System.out.println("Cannot load configuration file!");
		} finally {
			config.save();
		}
		return false;
	}
	
	public void setList(String category, String key, Object[] objValues, String comment) {
        List<String> valuesList = new ArrayList<String>();
        for(Object objValue : objValues)
            valuesList.add(objValue.toString());
        String[] values = valuesList.toArray(new String[valuesList.size()]);
		Property property = this.config.get(category, key, values);
		if(comment != null) property.setComment(comment);
		property.set(values);
		config.save();
	}
	
	public String[] getStringList(String category, String key) {
		return this.getStringList(category, key, new String[]{""});
	}
	
	public String[] getStringList(String category, String key, String[] defaultValue) {
		return this.getStringList(category, key, defaultValue, null);
	}
	
	public String[] getStringList(String category, String key, String[] defaultValue, String comment) {
        category = category.toLowerCase();
        boolean newEntry = !this.config.getCategory(category).containsKey(key);
		Property property = this.config.get(category, key, defaultValue);
		if(comment != null) property.setComment(comment);
        if(newEntry) this.config.save();
		return property.getStringList();
	}

}
