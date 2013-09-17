local args = {...}

if #args == 0 then
	d = 0
elseif #args == 1 then
	d = tonumber(args[1])
else
	print("Usage: right [amount:1]")
	error()
end

if turtle.getFuelLevel() < d then
	print("Not enough fuel: ", turtle.getFuelLevel(), "/", d)
	error()
end

turtle.turnRight()
for x = 1, d do
	if not turtle.forward() then
		print("Could only move ", x-1)
		break
	end
end