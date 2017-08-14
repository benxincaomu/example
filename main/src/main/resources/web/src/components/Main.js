import React from 'react'
import { Layout, Menu, Icon } from 'antd'
import JqueryUtil from "../components/commons/utils/JqueryUtil"
import PropTypes from 'prop-types';
import createBrowserHistory from 'history/createBrowserHistory'


const history = createBrowserHistory()
const { SubMenu } = Menu;
const { Header, Footer, Sider, Content } = Layout;
class AppComponent extends React.Component {
    pushPath(path) {
        if (path) {
            history.push(path);
        }
    }
    componentWillMount() {
        JqueryUtil.extendJquery();
    }

    render() {
        return (
            <div className='index'>

                <Layout>

                    <Header className='header'>
                        <div className='logo' />
                    </Header>
                    <Layout style={{ padding: '0 24px 24px' }}>
                        <Sider width={200} style={{ background: '#fff' }}>
                            {/* 菜单从服务器获取 */}
                            <Menu onClick={(e) => {
                                this.pushPath(e.key);
                            }}
                                mode='inline'
                                defaultSelectedKeys={['1']}
                                defaultOpenKeys={['sub1']}
                                style={{ minHeight: '70%' }}>
                                <SubMenu key='sub1' title={
                                    <span><Icon type="user" />菜单</span>
                                }>
                                    <Menu.Item key='/users'>
                                        用户管理
                                    </Menu.Item>
                                    <Menu.Item key='/roles'>
                                        角色管理
                                    </Menu.Item>
                                </SubMenu>
                            </Menu>
                        </Sider>
                        <Content style={{ background: '#fff', padding: 24, margin: 0, minHeight: 280 }}>
                            {this.props.children}
                        </Content>

                    </Layout>
                    <Footer> footer</Footer>
                </Layout>
            </div>
        )
    }
}
//定义属性的类型
AppComponent.propTypes = {
    children: PropTypes.object
};
//定义默认的属性
AppComponent.defaultProps = {};

export default AppComponent
