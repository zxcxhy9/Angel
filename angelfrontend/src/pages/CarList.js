import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import axios from 'axios';
import './CarList.css';

class CarList extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            id:'',
            name:'',
            cars:[]
        }

        this.addCar = this.addCar.bind(this);
    }

    componentDidMount() {
        this.query();
    }

    query() {
        //使用axios与服务器通讯
        axios.get('/cars')
          .then(response => {
              console.log(response.data);
            this.setState({cars: response.data.data});
        })
        .catch(function (error) {
            console.log(error);
        })

        //使用fetch与服务器通讯
        //let data = fetch('/cars').then(response => response.json());
        //data.then(res=> this.setState({cars: res}));
    }

    deleteCar(car) {
        axios.delete(`/car/${car.id}`).then(({data}) => {
            this.query();
        }).catch(function (error) {
            console.log(error);
        })
    }

    addCar(){
        let car = {
            id: this.state.id,
            name: this.state.name
        };

        axios.post(`/cars`, car).then(res=>{
            console.log("res:" + res.data);
            //this.query();
        }).catch(error=>{
            console.log(error);
        })
    }

    render() {
        return (
            <div className="container-fluid" style={{marginTop: '20px'}}>
                <div className="row">
                    <div className="col-xs-4 col-xs-offset-1">
                        <div className="panel panel-default">
                            <div className="panel-body">
                                <table className="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>id</th>
                                            <th>name</th>
                                            <th>操作</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    {
                                        this.state.cars.map(item=>{
                                            return (
                                                <tr key={item.id}>
                                                    <td>{item.id}</td>
                                                    <td>{item.name}</td>
                                                    <td>
                                                        <button className="btn btn-primary"
                                                                onClick={() => {
                                                            this.setState({id: item.id, name: item.name})
                                                        }}>修改</button>
                                                        <button className="btn btn-danger" style={{marginLeft:'5px'}}
                                                                onClick={() => {
                                                            this.deleteCar(item)
                                                        }}>删除</button>
                                                    </td>
                                                </tr>
                                            )
                                        })
                                    }
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div className="col-xs-3 col-xs-offset-1">
                        <div className="panel panel-default">
                            <div className="panel-body">
                                <form className="form-horizontal">
                                    <div className="form-group">

                                        <label htmlFor="id" className="col-xs-3">id</label>
                                        <input type="text" id="id" className="form-control" value={this.state.id} onChange={
                                                (e)=>{
                                                    this.setState({
                                                        id:e.target.value
                                                    })
                                                }
                                            }/>

                                        <label htmlFor="name" className="col-xs-3">name</label>
                                        <input type="text" id="name" className="form-control" value={this.state.name} onChange={
                                                (e)=>{
                                                    this.setState({
                                                        name:e.target.value
                                                    })
                                                }
                                            }/>
                                            <button className="btn btn-primary" onClick={this.addCar}>新增</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default CarList;