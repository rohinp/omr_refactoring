package com.omr.image.factories;

import java.io.IOException;

import net.sourceforge.jiu.codecs.ImageLoader;
import net.sourceforge.jiu.codecs.InvalidFileStructureException;
import net.sourceforge.jiu.codecs.InvalidImageIndexException;
import net.sourceforge.jiu.codecs.UnsupportedTypeException;
import net.sourceforge.jiu.color.reduction.RGBToGrayConversion;
import net.sourceforge.jiu.data.Gray8Image;
import net.sourceforge.jiu.data.PixelImage;
import net.sourceforge.jiu.data.RGB24Image;
import net.sourceforge.jiu.ops.MissingParameterException;
import net.sourceforge.jiu.ops.WrongParameterException;

public class ImageFactory {

	public static Gray8Image createGray8Image(String filePath) {
		PixelImage pixelImage = createPixelImage(filePath);
		if (pixelImage instanceof RGB24Image) {
			pixelImage = gray8FromRGB24(pixelImage);
		}
		return (Gray8Image) pixelImage;
	}

	public static PixelImage gray8FromRGB24(PixelImage pixelImage) {
		try {
			return convertRGB24ToGray8Image(pixelImage);
		} catch (Exception e) {
			throw new ImageFactoryConvertionErrorRGB24ToGray8(e.getMessage());
		}
	}

	private static PixelImage convertRGB24ToGray8Image(PixelImage pixelImage)
			throws Exception {
		RGBToGrayConversion rgbtogray = new RGBToGrayConversion();
		rgbtogray.setInputImage((RGB24Image) (pixelImage));
		rgbtogray.process();
		return rgbtogray.getOutputImage();
	}

	public static PixelImage createPixelImage(String filePath) {
		try {
			return ImageLoader.load(filePath);
		} catch (InvalidFileStructureException | InvalidImageIndexException
				| UnsupportedTypeException | IOException e) {
			throw new ImageFactoryUnableToLoadImage(e.getMessage());
		}
	}

	private static class ImageFactoryUnableToLoadImage extends RuntimeException {
		private static final long serialVersionUID = -3082331561995751803L;

		public ImageFactoryUnableToLoadImage(String message) {
			super(message);
		}
	}

	private static class ImageFactoryConvertionErrorRGB24ToGray8 extends
			RuntimeException {
		private static final long serialVersionUID = -8831462653121745399L;

		public ImageFactoryConvertionErrorRGB24ToGray8(String message) {
			super(message);
		}
	}

}
