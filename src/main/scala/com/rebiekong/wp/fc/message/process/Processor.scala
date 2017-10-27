package com.rebiekong.wp.fc.message.process

import com.rebiekong.wp.fc.message.input.BasicInput
import com.rebiekong.wp.fc.message.output.BasicOutput

abstract class Processor[T <: BasicInput]() {

  def run(input: T): BasicOutput

}
