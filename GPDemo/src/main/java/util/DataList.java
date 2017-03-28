package util;

import java.util.List;

import entity.Catalogue;
import entity.CatalogueExtend;
import entity.CatalogueThree;
import entity.MallingGoods;

public class DataList {
	public List<Catalogue> catalogue;
	public List<CatalogueExtend> catalogueExtend;
	public List<CatalogueThree> catalogueThree;
	public List<MallingGoods> mallingGoods;
	
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
	public List<CatalogueThree> getCatalogueThree() {
		return catalogueThree;
	}
	public void setCatalogueThree(List<CatalogueThree> catalogueThree) {
		this.catalogueThree = catalogueThree;
	}
	public List<MallingGoods> getMallingGoods() {
		return mallingGoods;
	}
	public void setMallingGoods(List<MallingGoods> mallingGoods) {
		this.mallingGoods = mallingGoods;
	}
	
	
}
