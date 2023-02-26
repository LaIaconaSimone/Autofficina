package com.example.autofficina.Services

import com.example.autofficina.Entity.Cliente

interface IClienteServices {

    fun addCliente(cliente:Cliente): Unit
    //fun removeCliente(cliente: Cliente): Unit
    fun getAllCliente(): List<Cliente>

}