package org.conan.persistence;

import org.apache.ibatis.annotations.Insert;

public interface Sample1Mapper {
	@Insert("insert into tbl_sample1(col1) value(#{data})")
	public int insertCol1(String data);
}
