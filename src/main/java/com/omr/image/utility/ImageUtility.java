package com.omr.image.utility;

import net.sourceforge.jiu.codecs.CodecMode;
import net.sourceforge.jiu.codecs.PNGCodec;
import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.data.PixelImage;

public class ImageUtility {

	public final int cordinatesAdditionValues[][] = { { 0, 0 }, { 1, 1 },
			{ -1, -1 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 },
			{ -1, 1 }};

	private PNGCodec pngCodec;
	
	public void saveImageToPNG(PixelImage img, String filename) {
		try {
			pngCodec = new PNGCodec();
			pngCodec.setFile(filename, CodecMode.SAVE);
			pngCodec.setImage(img);
			pngCodec.setCompressionLevel(0);
			pngCodec.process();
		} catch (Exception ex) {
			throw new ImageUtilitySaveToPNGException();
		}
	}

	public void putWhiteMark(Gray8Image img, int x, int y) {
		for (int[] cord : cordinatesAdditionValues) {
			img.putWhite(x + cord[0], y + cord[1]);
		}
	}

	public void putBlackMark(Gray8Image img, int x, int y) {
		for (int[] cord : cordinatesAdditionValues) {
			img.putBlack(x + cord[0], y + cord[1]);
		}
	}
	
	public class ImageUtilitySaveToPNGException extends RuntimeException {
		private static final long serialVersionUID = 1L;
	}

}
