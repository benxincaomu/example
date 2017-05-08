package org.sft.sample.common.config.redis;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoRedisSerializer<T> implements RedisSerializer<T> {
	
	@Override
	public byte[] serialize(Object t) throws SerializationException {
		Kryo kryo = new Kryo();
		byte[] buffer = new byte[2048];
		Output output = new Output(buffer);
		kryo.writeClassAndObject(output, t);
		return output.toBytes();
	}

	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		Kryo kryo = new Kryo();
		Input input = new Input(bytes);
		@SuppressWarnings("unchecked")
		T t = (T) kryo.readClassAndObject(input);
		return t;
	}

}
