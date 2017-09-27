package system.web.service.impl.menu;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import system.core.service.impl.CommonServiceImpl;
import system.web.service.menu.Sys_BaseMenuServiceI;
@Service("sys_BaseMenuServiceI")
@Transactional
public class Sys_BaseMenuServiceImpl extends CommonServiceImpl implements Sys_BaseMenuServiceI{

}
