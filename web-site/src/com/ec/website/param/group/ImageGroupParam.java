package com.ec.website.param.group;

import java.util.ArrayList;
import java.util.List;

import com.ec.website.param.ImageParam;

public class ImageGroupParam extends AbstractGroupParam<ImageGroupParam,ImageParam>{
	private List<ImageParam> pics = new ArrayList<ImageParam>();
	public ImageGroupParam(String title) {
		super("image", title);
	}
	@Override
	public String getTemplatePath() {
		// TODO Auto-generated method stub
		return "image.jsp";
	}

	@Override
	public List<ImageParam> getValues() {
		// TODO Auto-generated method stub
		return pics;
	}
	@Override
	public ImageGroupParam addValue(ImageParam value) {
		pics.add(value);
		return this;
	}

}
