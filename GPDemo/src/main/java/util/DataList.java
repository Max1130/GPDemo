package util;

import java.util.List;

import entity.Catalogue;
import entity.CatalogueExtend;

public class DataList {
	public List<Catalogue> catalogue;
	public List<CatalogueExtend> catalogueExtend;
	
	public List<Catalogue> getCatalogue() {
		return catalogue;
	}
	public void setCatalogue(List<Catalogue> catalogue) {
		this.catalogue = catalogue;
	}
	public List<CatalogueExtend> getCatalogueExtend() {
		return catalogueExtend;
	}
	public void setCatalogueExtend(List<CatalogueExtend> catalogueExtend) {
		this.catalogueExtend = catalogueExtend;
	}
	
}
