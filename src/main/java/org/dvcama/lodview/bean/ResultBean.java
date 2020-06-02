package org.dvcama.lodview.bean;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ResultBean {

	private String title, latitude = null, longitude = null, mainIRI = null;
	private PropertyBean descriptionProperty = null, typeProperty = null;
	private List<String> images = null, linking = null, videos = null, audios = null;
	private Map<String, LinkedHashMap<PropertyBean, List<TripleBean>>> literals = new HashMap<String, LinkedHashMap<PropertyBean, List<TripleBean>>>(), resources = new HashMap<String, LinkedHashMap<PropertyBean, List<TripleBean>>>(), bnodes = new HashMap<String, LinkedHashMap<PropertyBean, List<TripleBean>>>();

	private Map<String, LinkedHashMap<PropertyBean, List<TripleBean>>> addEle(final String IRI, final TripleBean tripleBean, final Map<String, LinkedHashMap<PropertyBean, List<TripleBean>>> ele) {
		if (ele.get(IRI) == null || ele.get(IRI).get(tripleBean.getProperty()) == null) {
			LinkedHashMap<PropertyBean, List<TripleBean>> a = ele.get(IRI);
			if (a == null) {
				a = new LinkedHashMap<PropertyBean, List<TripleBean>>();
			}
			final List<TripleBean> b = new ArrayList<TripleBean>();
			b.add(tripleBean);
			a.put(tripleBean.getProperty(), b);
			ele.put(IRI, a);
		} else {
			final LinkedHashMap<PropertyBean, List<TripleBean>> a = ele.get(IRI);
			final List<TripleBean> b = a.get(tripleBean.getProperty());
			b.add(tripleBean);
			a.put(tripleBean.getProperty(), b);
			ele.put(IRI, a);
		}
		return ele;
	}

	private Map<String, LinkedHashMap<PropertyBean, List<TripleBean>>> removeEle(final String IRI, final TripleBean tripleBean, final Map<String, LinkedHashMap<PropertyBean, List<TripleBean>>> ele) {
		if (ele.get(IRI) == null || ele.get(IRI).get(tripleBean.getProperty()) == null) {

		} else {
			final LinkedHashMap<PropertyBean, List<TripleBean>> a = ele.get(IRI);
			final List<TripleBean> b = a.get(tripleBean.getProperty());
			b.remove(tripleBean);
			a.put(tripleBean.getProperty(), b);
			ele.put(IRI, a);
		}
		return ele;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(final List<String> images) {
		this.images = images;
	}

	public void setLiterals(final String IRI, final List<TripleBean> localLiterals) {
		for (final TripleBean tripleBean : localLiterals) {
			literals = addEle(IRI, tripleBean, literals);
		}

	}

	public void setBnodes(final String IRI, final List<TripleBean> localBnodes) {
		for (final TripleBean tripleBean : localBnodes) {
			bnodes = addEle(IRI, tripleBean, bnodes);
		}

	}

	public void setResources(final String IRI, final List<TripleBean> Localresources) {
		for (final TripleBean tripleBean : Localresources) {
			resources = addEle(IRI, tripleBean, resources);
		}

	}

	public LinkedHashMap<PropertyBean, List<TripleBean>> getResources(final String IRI) {
		return resources.get(IRI);
	}

	public LinkedHashMap<PropertyBean, List<TripleBean>> getLiterals(final String IRI) {
		return literals.get(IRI);
	}

	public  Map<String, LinkedHashMap<PropertyBean, List<TripleBean>>> getLiterals() {
		return literals;
	}
	public LinkedHashMap<PropertyBean, List<TripleBean>> getBnodes(final String IRI) {
		return bnodes.get(IRI);
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(final String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public List<String> getAudios() {
		return audios;
	}

	public List<String> getVideos() {
		return videos;
	}

	public void setLatitude(final String latitude) {
		this.latitude = latitude;
	}

	public List<String> getLinking() {
		return linking;
	}

	public void setLinking(final List<String> linking) {
		this.linking = linking;
	}

	@Override
	public String toString() {
		return "ResultBean [title=" + title + ", \ndescriptionProperty=" + descriptionProperty + ", \nlatitude=" + latitude + ", \nlongitude=" + longitude + ", \nimages=" + images + ", \nlinking=" + linking + ", \nliterals=" + literals + ", \nresources=" + resources + ", \nbnodes=" + bnodes + "]";
	}

	public String getMainIRI() throws UnsupportedEncodingException {
		return mainIRI;//new String(mainIRI.getBytes("ISO-8859-1"), "UTF-8");
	}
	public String getMainIRI(final boolean isheader) throws UnsupportedEncodingException {
		return new String(mainIRI.getBytes("ISO-8859-1"), "UTF-8");
	}
	public void setMainIRI(final String mainIRI) {
		this.mainIRI = mainIRI;
	}

	public void addBnode(final TripleBean tripleBean, final String IRI) {

		bnodes = addEle(IRI, tripleBean, bnodes);
	}

	public void addLiteral(final TripleBean tripleBean, final String IRI) {
		literals = addEle(IRI, tripleBean, literals);

	}

	public void addResource(final TripleBean tripleBean, final String IRI) {
		resources = addEle(IRI, tripleBean, resources);
	}

	public void removeBnode(final TripleBean tripleBean, final String IRI) {

		bnodes = removeEle(IRI, tripleBean, bnodes);
	}

	public void removeLiteral(final TripleBean tripleBean, final String IRI) {
		literals = removeEle(IRI, tripleBean, literals);

	}

	public void removeResource(final TripleBean tripleBean, final String IRI) {
		resources = removeEle(IRI, tripleBean, resources);
	}

	public PropertyBean getDescriptionProperty() {
		return descriptionProperty;
	}

	public void setDescriptionProperty(final PropertyBean descriptionProperty) {
		this.descriptionProperty = descriptionProperty;
	}

	public PropertyBean getTypeProperty() {
		return typeProperty;
	}

	public void setTypeProperty(final PropertyBean typeProperty) {
		this.typeProperty = typeProperty;
	}

	public void setVideos(final List<String> videos) {
		this.videos = videos;
	}

	public void setAudios(final List<String> audios) {
		this.audios = audios;
	}

}
