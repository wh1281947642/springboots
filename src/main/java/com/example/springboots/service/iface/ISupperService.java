package com.example.springboots.service.iface;

import java.util.List;

/**
 * service顶层接口
 * @author rain
 *
 * @param <T>
 */
public interface ISupperService<T> {
    
    /**
     * 
     * 新增(每个字段都会插入)
     * <功能详细描述>
     * @param o 实体
     * @return  受影响的行数
     * @see
     * @since 1.0
     */
    int insert(T o);
    
    /**
     * 
     * 有选择性的新增(不为空的字段才会插入)
     * <功能详细描述>
     * @param o
     * @return 受影响的行数
     * @see
     * @since 1.0
     */
    int insertSelective(T o);
    
    /**
     * 
     * 删除
     * <功能详细描述>
     * @param o
     * @return 受影响的行数
     * @see
     * @since 1.0
     */
    int delete(T o);
    
    /**
     * 
     * 根据主键删除
     * <功能详细描述>
     * @param id
     * @return 受影响的行数
     * @see
     * @since 1.0
     */
    int deleteByPrimaryKey(String id);
    
    /**
     * 
     * 跟新(全部字段都会跟新)
     * <功能详细描述>
     * @param o
     * @return 受影响的行数
     * @see
     * @since 1.0
     */
    int updateByPrimaryKey(T o);
    
    /**
     * 
     * 选择新跟新（只跟新为空的字段）
     * <功能详细描述>
     * @param o
     * @return 受影响的行数
     * @see
     * @since 1.0
     */
    int updateByPrimaryKeySelective(T o);
    
    /**
     * 
     * 根据主键查询实体
     * @param id 主键
     * @return T 实体
     * @see
     * @since 1.0
     */
	T selectByPrimaryKey(String id);
	
	/**
	 * 
	 * 查询所有的记录
	 * @return 实体的集合
	 * @see
	 * @since 1.0
	 */
	List<T> selectAll();
}
