package com.example.springboots.service.iface.imp;

import com.example.springboots.service.iface.ISupperMapper;
import com.example.springboots.service.iface.ISupperService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * service顶层接口实现
 * @author rain
 *
 * @param <T>
 */
public abstract class UtoreBaseService<T> implements ISupperService<T> {
	
	public abstract ISupperMapper<T> getMapper();
	
	@Transactional(value="utoreTransactionManager")
    public int insert(T o) {
        return this.getMapper().insert(o);
    }
	
    @Override
    @Transactional(value="utoreTransactionManager")
    public int insertSelective(T o) {
	    return this.getMapper().insertSelective(o);
    }
	
	@Override
    @Transactional(value="utoreTransactionManager")
    public int delete(T o) {
        return this.getMapper().delete(o);
    }
	
	@Override
    @Transactional(value="utoreTransactionManager")
    public int deleteByPrimaryKey(String id) {
        return this.getMapper().deleteByPrimaryKey(id);
    }
	
	@Override
    @Transactional(value="frameworkTransactionManager")
    public int updateByPrimaryKey(T o) {
        return this.getMapper().updateByPrimaryKey(o);
    }
	
	@Override
    @Transactional(value="utoreTransactionManager")
    public int updateByPrimaryKeySelective(T o) {
        return this.getMapper().updateByPrimaryKeySelective(o);
    }
	
	
	
	@Override
	//@Cacheable(value = "frameworkCache")
	public T selectByPrimaryKey(String id) {
		return this.getMapper().selectByPrimaryKey(id);
	}
	
    @Override
    public List<T> selectAll() {
        return this.getMapper().selectAll();
    }
}
