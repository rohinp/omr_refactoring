package com.omr.image.utility;

import java.io.IOException;

import net.sourceforge.jiu.codecs.CodecMode;
import net.sourceforge.jiu.codecs.InvalidFileStructureException;
import net.sourceforge.jiu.codecs.PNGCodec;
import net.sourceforge.jiu.codecs.UnsupportedCodecModeException;
import net.sourceforge.jiu.codecs.UnsupportedTypeException;
import net.sourceforge.jiu.codecs.WrongFileFormatException;
import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.data.PixelImage;
import net.sourceforge.jiu.ops.MissingParameterException;
import net.sourceforge.jiu.ops.OperationFailedException;

public class ImageUtility {

	public final int cordinatesAdditionValues[][] = { { 0, 0 }, { 1, 1 },
			{ -1, -1 }, { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, -1 },
			{ -1, 1 } };

	public void saveImageToPNG(PixelImage img, String filename) {
		try {
			pngProcessing(img, filename);
		} catch (OperationFailedException | IOException e) {
			throw new ImageUtilitySaveToPNGException(e.getMessage());
		}
	}

	private void pngProcessing(PixelImage img, String filename)
			throws IOException, UnsupportedCodecModeException,
			InvalidFileStructureException, MissingParameterException,
			OperationFailedException, UnsupportedTypeException,
			WrongFileFormatException {
		
		PNGCodec pngCodec = new PNGCodec();
		pngCodec.setFile(filename, CodecMode.SAVE);
		pngCodec.setImage(img);
		pngCodec.setCompressionLevel(0);
		pngCodec.process();
		
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
		public ImageUtilitySaveToPNGException(String message) {
			super(message);
		}

		private static final long serialVersionUID = 1L;
	}

}
